const axios = require("axios");
const url = "http://localhost:8080"

const Withdraw = (value, fn) => {
    axios
        .post(`${url}/withdraw/${value}`)
        .then(response => fn(response))
}

export {
    Withdraw,
}