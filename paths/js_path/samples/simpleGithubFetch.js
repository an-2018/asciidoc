const https = require('https')

function fetchGithubUser(login) {
    const api = "https://api.github.com/users";
    console.log(`${api}/${login}`)
    return https.get(`${api}/${login}`, res => {
        res.setEncoding("utf-8")
        let body = ""

        res.on("data", data => {
            console.log(" data " + data)
            body += data
        })
        res.on("end", () => {
            body = JSON.parse(body);
            console.log(body);
        })
    })
}

fetchGithubUser("an-2018")