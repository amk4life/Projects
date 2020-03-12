from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_login import LoginManager

ecomm = Flask(__name__)
ecomm.config.from_object('config')

#Initializing essential objects
db = SQLAlchemy(ecomm)
login_manager = LoginManager()
login_manager.init_app(ecomm)

