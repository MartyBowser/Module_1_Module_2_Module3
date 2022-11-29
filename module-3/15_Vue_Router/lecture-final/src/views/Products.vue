<template>
  <div class="products">
      <h1>Products</h1>
      <p v-if="isAdmin">Only an admin should see this</p>
      <products-list />
   </div>
</template>

<script>
import ProductsList from '../components/ProductsList.vue'

export default {
    components: {
        ProductsList
    },
    data(){
        return {
            showElement: false,
            isAdmin: false
        }
    }
}
</script>

<style>

</style>