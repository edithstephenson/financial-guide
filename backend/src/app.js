
const Server = require("./configurations/server");
require("./configurations/routes")(Server);

require("./configurations/database");