<template>
  <div>
      <form class="new-book-form" v-on:submit.prevent='saveBook'>
          <input type="text" class='title-input' v-model="book.title"/>
          <input type="text" class='author-input' v-model="book.author"/>
          <input type="text" class='isbn-input' v-model="book.isbn"/> 
          <button>save</button>
      </form>
  </div>
</template>

<script>
export default {
    name: "new-book-form",
    data() {
        return {
            book: {
                title: '',
                author: '',
                read: false,
                isbn: ''
            }
        }
    },
    methods: {
        saveBook() {
            this.$store.commit('ADD_NEW_BOOK', this.book);
            this.book = {
                title: '',
                author: '',
                read: false,
                isbn: ''
            };
        }
    }
}
</script>
<style>

</style>