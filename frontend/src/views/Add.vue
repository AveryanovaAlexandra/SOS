<template>
    <div>
        <div v-if="!submitted">
            <div class="mb-3">
                <label for="name" class="form-label">Название</label>
                <input type="text" class="form-control" id="name" required name="name" v-model="book.name">
            </div>
            <div class="mb-3">
                <label for="author" class="form-label">Автор</label>
                <input type="text" class="form-control" id="author" required name="author" v-model="book.author">
            </div>
            <div class="mb-3">
                <label for="year" class="form-label">Год издания</label>
                <input type="text" class="form-control" id="year" required name="year" v-model="book.year">
            </div>
            <div class="mb-3">
                <label for="pages" class="form-label">Количество страниц</label>
                <input type="text" class="form-control" id="pages" required name="pages" v-model="book.pages">
            </div>
            <div class="mb-3">
              <label for="publishing" class="form-label">Место публикации</label>
              <input type="text" class="form-control" id="publishing" required name="publishing" v-model="book.publishing">
            </div>
            <div class="mb-3">
              <label for="link" class="form-label">Ссылка</label>
              <input type="text" class="form-control" id="link" required name="link" v-model="book.link">
            </div>
            <div class="mb-3">
                <button @click="saveBook" class="btn btn-primary">Добавить</button>
            </div>
        </div>
        <div v-else>
            <div class="alert alert-success" role="alert">
                Электронный ресурс сохранен
            </div>
            <button @click="newBook" class="btn btn-primary">Добавить еще один</button>
        </div>
    </div>
</template>

<script>
import BookService from './components/services/BookService.js'
export default {
    name: 'add',
    data() {
        return {
            book: {
                id: null,
                name: "",
                author: "",
                year:"",
                pages:"",
                publishing:"",
                link:""
            },
            submitted: false
        }
    },
    methods: {
        saveBook() {
            var data = {
                name: this.book.name,
                author: this.book.author,
                year: this.book.year,
                pages: this.book.pages,
                publishing:this.book.publishing,
                link:this.book.link
            }
            BookService.create(data)
                .then(response => {
                    this.book.id = response.data.id
                    this.submitted = true;
                })
                .catch( e => {
                    console.log(e);
                    alert(e)
                })
        },
        newBook() {
            this.submitted = false
            this.book = {}
        }
    }
}
</script>
