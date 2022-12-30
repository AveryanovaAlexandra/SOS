import axios from 'axios';
class BookService {
    getAll() {
        return axios.get('http://localhost:8081/api/books');
    }

    get(id) {
        return axios.get(`http://localhost:8081/api/books/${id}`)
    }

    create(data) {
        return axios.post('http://localhost:8081/api/books/', data)
    }

    update(id, data) {
        return axios.put(`http://localhost:8081/api/books/${id}`, data)
    }

    delete(id) {
        return axios.delete(`http://localhost:8081/api/books/${id}`)
    }
}

export default new BookService()