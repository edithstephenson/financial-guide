const nodeRestful = require("node-restful");
const mongoose = nodeRestful.mongoose;

const usersSchema = new mongoose.Schema({
     name: {type: String, required: true },
     email: {type: String, required: true },
     password: {type: String, required: true },
     image: {type: String, required: false },
});

module.exports = nodeRestful.model("users", usersSchema);