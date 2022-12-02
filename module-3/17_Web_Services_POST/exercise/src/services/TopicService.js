import axios from 'axios';
 
const http = axios.create({
  baseURL: "http://localhost:3000"
});
 
export default {
 
  list() {
    return http.get('/topics');
  },
 
  get(id) {
    return http.get(`/topics/${id}`);
  },
 
  create(topic) {
    return http.post('/topics', topic);
  },
 
  update(id, topic) {
    return http.put(`/topics/${id}`, topic);
  },
 
  delete(id) {
    return http.delete(`/topics/${id}`);
  }
 
}
