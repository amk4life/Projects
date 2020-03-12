from flask import request
from flask import Flask, render_template, redirect, url_for, flash
from forms import registrationForm, loginForm
from flask_sqlalchemy import SQLAlchemy
from werkzeug.security import generate_password_hash, check_password_hash
import stripe
from flask_admin import Admin
from flask_admin.contrib.sqla import ModelView


"""
     App Config
"""


ecomm = Flask(__name__)
ecomm.config['SECRET_KEY'] = '5aa6face94d8ddee195ead1c27068eec'
ecomm = Flask(__name__)
UPLOAD_FOLDER = 'static/uploads'
ALLOWED_EXTENSIONS = set(['jpeg', 'jpg', 'png', 'gif'])
ecomm.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
ecomm.config['FLASK_ADMIN_SWATCH'] = 'cerulean'
stripe_pub_key = "pk_test_CtGgbrtjGwLPocM587Gj63ny00mGIuJ4TS"
stripe.api_key = 'sk_test_mnOsTyQ9docAoGBoYEvFoDcm00mIvxfSmd'


"""
     Routes
"""


@ecomm.route('/home')
def index():
    return render_template('home.html', leftNav=leftNav_items(), rightNav=rightNav_items(), title="Home Page")


@ecomm.route('/')
@ecomm.route('/products')
def products():
    products = Products.query.all()
    return render_template('products.html', products=products, leftNav=leftNav_items(), rightNav=rightNav_items())


@ecomm.route('/productDescription')
def productDescription():
    productId = request.args.get('productId')
    productData = Products.query.filter_by(product_id=productId).first()

    return render_template("productDescription.html", data=productData, leftNav=leftNav_items(), rightNav=rightNav_items())


@ecomm.route('/cart')
def cart():
    cart_list = Cart.query.all()
    cart_items = []
    for product in cart_list:
        if Products.query.filter_by(product_id=product.product_id).first() is not None:
            cart_items.append(Products.query.filter_by(product_id=product.product_id).first())

    total_price = 0
    for item in cart_items:
        total_price += item.price

    # Cent value meant for stripe payments
    total_price_cents = round(total_price * 100)
    total_price = "{:.2f}".format(total_price)

    return render_template("cart.html", leftNav=leftNav_items(), rightNav=rightNav_items(), products=cart_items,
                           totalPrice=total_price, total_price_cents=total_price_cents, stripe_pub_key=stripe_pub_key)


@ecomm.route('/addToCart')
def addToCart():
    product_id = int(request.args.get('productId'))
    product = Cart(product_id=product_id)
    print(product)
    db.session.add(product)
    db.session.commit()
    return redirect(url_for('products'))


@ecomm.route("/removeFromCart")
def removeFromCart():
    product_id = int(request.args.get('productId'))
    product = Cart.query.filter_by(product_id=product_id).first()
    db.session.delete(product)
    db.session.commit()
    return redirect(url_for('cart'))


@ecomm.route('/about')
def about():
    return render_template('about.html', leftNav=leftNav_items(), rightNav=rightNav_items(), title="About Page")


@ecomm.route('/contact')
def contact_us():
    return render_template('contact.html', leftNav=leftNav_items(), rightNav=rightNav_items(), title="Contact Page")


@ecomm.route("/signin", methods=['GET', 'POST'])
def signin():
    form = loginForm()
    if form.validate_on_submit():
        """
            Query login info against DB and authenticate user
        """
        user = User.query.filter_by(username=form.username.data, email=form.email.data).first()

        """
             Handle login use cases
        """

        if user is None:
            flash("User Not Found - Please Sign Up")
        elif user.check_password(form.password.data):
            flash("Welcome Back User!!")
        else:
            flash("Invalid Login Credentials")

        return redirect(url_for('index'))
    return render_template('signin.html', leftNav=leftNav_items(), rightNav=rightNav_items(), title="Sign In Page",
                           form=form)


@ecomm.route("/signup", methods=['GET', 'POST'])
def signup():
    form = registrationForm()
    if form.validate_on_submit():
        """
             Instantiate new user
             Hash user password
             Insert and commit user record to DB
        """
        new_user = User(username=form.username.data, email=form.email.data)
        new_user.set_password(form.password.data)
        db.session.add(new_user)
        db.session.commit()
        db.session.close()

        """
             Alert User of Proper Registration
        """
        flash('Account Created! Login to Start Shopping!', 'success')
        return redirect(url_for('index'))
    return render_template('signup.html', leftNav=leftNav_items(), rightNav=rightNav_items(), title="Sign Up Page",
                           form=form)


@ecomm.route("/pay", methods=['GET', 'POST'])
def process_payment():
    """
         Create customer object using the information received from cart page and pass it to the strip API
    """
    amount_string = (request.args.get('amount', 100))
    amount = float(amount_string)
    amount_cents = round(amount * 100)  # Stripe api accepts amount only in cents
    customer = stripe.Customer.create(email=request.form['stripeEmail'], source=request.form['stripeToken'])
    stripe.Charge.create(customer=customer.id, amount=amount_cents, currency='usd',
                             description="The E-commerce Store")
    return redirect(url_for('thank_you'))


@ecomm.route("/thankyou", methods=['GET', 'POST'])
def thank_you():
    """
         Thank you page displayed after order completion
    """
    clear_cart()
    return render_template('thankyou.html', leftNav=leftNav_items(), rightNav=rightNav_items(), title="Thank You")


"""
     Helper Functions
"""


def leftNav_items():

    """
         List of tuples containing slugs and title for left nav menu
    """
    return [('/products', 'Products'), ('/about', 'About Us'), ('/contact', 'Contact Us')]

#    return [('/home', 'Home'), ('/products', 'Products'), ('/about', 'About Us'), ('/contact', 'Contact Us')]


def rightNav_items():

    """
         List of tuples containing slugs and title for right nav menu
    """
    return [('/cart', 'Cart'), ('/account', 'Account')]


def clear_cart():
    """
        Clear shopping cart
    """
    all_products = Cart.query.all()
    for product in all_products:
        db.session.delete(product)
        db.session.commit()


"""
     Database
"""


def init_db():
    global db
    ecomm.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
    ecomm.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///data.db'
    ecomm.config['SECRET_KEY'] = '5aa6face94d8ddee195ead1c27068eec'
    ecomm.config['SEND_FILE_MAX_AGE_DEFAULT'] = 0
    db = SQLAlchemy(ecomm)


init_db()

"""
     Model
"""


class User(db.Model):
    __tablename__ = 'users'
    __table_args__ = {'extend_existing': True}

    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(20))
    email = db.Column(db.String(120), index=True, unique=True)
    password_hash = db.Column(db.String(128))

    def set_password(self, password):
        self.password_hash = generate_password_hash(password)

    def check_password(self, password):
        return check_password_hash(self.password_hash, password)


class Products(db.Model):
    __tablename__ = 'products'
    __table_args__ = {'extend_existing': True}

    product_id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(30))
    price = db.Column(db.Float)
    description = db.Column(db.String(250))
    image = db.Column(db.String())
    stock = db.Column(db.Integer)

    def __repr__(self):
        return '%r' % self.name


class Cart(db.Model):
    __tablename__ = "cart"
    __table_args__ = {'extend_existing': True}
    cart_id = db.Column(db.Integer, primary_key=True)
    product_id = db.Column(db.Integer, db.ForeignKey('products.product_id'))
    parent = db.relationship('Products', backref=db.backref('Cart', lazy='dynamic'))


"""
     Flask Admin
"""


admin = Admin(ecomm, name='Store', template_mode='bootstrap3')
admin.add_view(ModelView(User, db.session))
admin.add_view(ModelView(Products, db.session))
admin.add_view(ModelView(Cart, db.session))


if __name__ == "__main__":
    ecomm.run(debug=True)
