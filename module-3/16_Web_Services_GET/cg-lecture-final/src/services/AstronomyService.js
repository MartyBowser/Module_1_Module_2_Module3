import axios from 'axios';

const http = axios.create({
    baseURL: "https://api.nasa.gov"
})

const apiKey = "DEMO_KEY"
export default {

    getPicOfTheDay() {
        const url = "/planetary/apod?api_key=" + apiKey;
        return http.get(url);
    },

    getNearEarthObjects(startDate, endDate) {
        const url = `/neo/rest/v1/feed?start_date=${startDate}&end_date=${endDate}&api_key=${apiKey}`;
        return http.get(url)
    }

}