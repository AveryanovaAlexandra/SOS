<template>
    <div v-if="currentBook">
        <div class="mb-3">
            <label for="name" class="form-label">Имя</label>
            <input type="text" class="form-control" id="name" required name="name" v-model="currentBook.name">
        </div>
        <div class="mb-3">
            <label for="author" class="form-label">Автор</label>
            <input type="text" class="form-control" id="author" required name="author" v-model="currentBook.author">
        </div>
        <div class="mb-3">
            <label for="year" class="form-label">Год издания</label>
            <input type="year" class="form-control" id="year" required name="year" v-model="currentBook.year">
        </div>
        <div class="mb-3">
            <label for="pages" class="form-label">Количество страниц</label>
            <input type="text" class="form-control" id="pages" required name="pages" v-model="currentBook.pages">
        </div>
        <div class="mb-3">
          <label for="publishing" class="form-label">Место публикации</label>
          <input type="text" class="form-control" id="publishing" required name="publishing" v-model="currentBook.publishing">
        </div>
        <div class="mb-3">
          <label for="link" class="form-label">Ссылка</label>
          <input type="text" class="form-control" id="link" required name="link" v-model="currentBook.link">
        </div>
        <div class="mb-3">
            <button @click="updateBook" class="btn btn-primary me-3">Обновить</button>
        </div>
         <div class="alert alert-success" role="alert" v-if="message">
            {{message}}
        </div>
    </div>
</template>
<script>
import BookService from './components/services/BookService.js'

export default {
    data() {
        return {
            currentBook: null,
            message: ''
        }
    },
    methods: {
        getBook(id) {
            BookService.get(id)
                .then(response => {
                    this.currentBook = response.data
                })
                .catch(e => {
                    alert(id)
                })
        },
        updateBook() {
            BookService.update(this.currentBook.id, this.currentBook)
                .then(() => {
                    this.message = 'Электронный курс успешно обновлен'
                })
                .catch(e => {

                    alert(e)
                })
        },
        deleteBook() {
            BookService.delete(this.currentBook.id)
                .then(() => {
                    this.$router.push({name: 'list'})
                })
                .catch(e => {
                    console.log(this.currentBook.id);
                    console.log(e);
                    alert(e)
                })
        }
    },
    mounted() {
        this.getBook(this.$route.params.id)
    }
}
</script>
