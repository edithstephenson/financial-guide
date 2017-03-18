const mongoose = require("mongoose");

mongoose.Promisse = global.Promise;

const DATABASE_URL = 'mongodb://financialAppUser:123456@ds135680.mlab.com:35680/heroku_tss1kcgb';

module.exports = mongoose.connect(DATABASE_URL);