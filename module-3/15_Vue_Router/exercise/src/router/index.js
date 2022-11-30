import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import MyBooks from '../views/MyBooks.vue';
import NewBook from '../views/NewBook.vue';
import BookDetail from '../views/BookDetail';
Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    component: Home,
    name: 'Home'
  },
  
    {
      path: '/myBooks',
      component: MyBooks,
      name: 'MyBooks'
    },
    {
      path: '/addBook',
      component: NewBook,
      name: 'NewBook'
    },
    {
      path: '/book/:id',
      name: 'book',
      component: BookDetail
    }
];

const router = new VueRouter({
  mode: 'history',
  routes
});



export default router;