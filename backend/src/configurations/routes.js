const express = require("express");
const billingCycleService = require("../api/v1/billingCycle/billingCycleService");

module.exports = (Server) => {
    const router = express.Router();

    Server.use("/api/v1", router);
    billingCycleService.register(router, "/billingCycles");

}