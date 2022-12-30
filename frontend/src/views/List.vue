<template>
    <div>
        <table class="table">
            <thead>
                <tr>
                <th scope="col">Название</th>
                <th scope="col">Автор</th>
                <th scope="col">Год издания</th>
                <th scope="col">Количество страниц</th>
                <th scope="col">Место публикации</th>
                <th scope="col">Ссылка</th>
                <th scope="col">Действие</th>
                </tr>
            </thead>
            <tbody v-for="book in books" v-bind:key="book.id">
                <tr>
                    <td>{{book.name}}</td>
                    <td>{{book.author}}</td>
                    <td>{{book.year}}</td>
                    <td>{{book.pages}}</td>
                    <td>{{book.publishing}}</td>
                    <td><a :href="book.link">Загрузка</a></td>
                    <td><a :href="'/books/' + book.id" class="btn btn-primary">Edit</a></td>
                </tr>

            </tbody>
        </table>
    </div>
</template>

<script>
import BookService from './components/services/BookService.js'

export default {
    name: 'list',
    data() {
        return {
            books: []
        }
    },
    methods: {
        retrieveBooks() {
            BookService.getAll()
                .then((response) => {
                    this.books = response.data
                })
                .catch(e => {
                    alert(e)
                })
        }
    },
    mounted() {
        this.retrieveBooks()
    }
}
</script>
