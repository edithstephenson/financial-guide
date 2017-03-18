const express = require("express");
const bodyParser = require("body-parser");

const defaultPort = 3005;
const Server = express();

Server.use(bodyParser.urlencoded({extended: true}));
Server.use(bodyParser.json());

Server.listen(process.env.PORT || defaultPort, () =>{
    console.log(`The financial partnner backend app is running on ${defaultPort}`);
});

module.exports = Server;