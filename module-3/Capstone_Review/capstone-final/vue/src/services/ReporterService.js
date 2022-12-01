import axios from 'axios';

export default {
    saveReporter(reporter) {
        return axios.post("/reporters", reporter)
    }
}