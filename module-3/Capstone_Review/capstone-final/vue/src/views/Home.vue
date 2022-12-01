<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <reporter-form></reporter-form>
  </div>
</template>

<script>
import ReporterForm from '@/components/ReporterForm.vue'
export default {
  name: "home",
  components: {
    ReporterForm
  }
};
</script>
