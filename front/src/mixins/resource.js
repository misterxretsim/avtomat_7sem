import Vue from 'vue'

export default {
    post(requestBody) {
        return Vue.http.post('/api', JSON.stringify(requestBody), {
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then((resp) => Promise.resolve(resp))
        .catch((err) => Promise.reject(err))
    }
}