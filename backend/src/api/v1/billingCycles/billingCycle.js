const nodeRestful = require("node-restful");
const mongoose = nodeRestful.mongoose;

const credtSchema = new mongoose.Schema({
    name: {type: String, required: true },
    value: {type: Number, min: 0, required: true}
}); 

const debtSchema = new mongoose.Schema({
    name: {type: String, required: true },
    value: {type: Number, min: 0, required: true},
    status: {
        type: String,
        required: false, 
        uppercase: true,
        enum: ["PAID", "PENDING", "SCHEDULED"]
    }
});

const billingCycleSchema = new mongoose.Schema({
     name: {type: String, required: true },
     month: {type: Number, min: 0, max: 12, required: true},
     year: {type: Number, min: 1970, max: 2100, required: true},
     credits: [credtSchema],
     debts: [debtSchema]
});

module.exports = nodeRestful.model("BillingCycle", billingCycleSchema);