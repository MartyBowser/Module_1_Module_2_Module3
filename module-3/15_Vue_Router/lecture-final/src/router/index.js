import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '../views/Products.vue'
import ProductDetail from '../views/ProductDetail.vue'
import AddReview from '../views/AddReview.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: Products,
    name: 'products'
  },
  {
    path: '/details/:productId',
    component: ProductDetail,
    name: 'product-detail'
  },
  {
    path: '/details/:productId/add-review',
    component: AddReview,
    name: "add-review"
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
