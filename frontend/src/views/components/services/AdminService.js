import axios from 'axios';
class AdminService {
    getAdmin() {
        return axios.get('http://localhost:8081/api/admin');
    }
    update(id, data) {
        return axios.put(`http://localhost:8081/api/admin/${id}`, data)
    }
}

export default new AdminService()