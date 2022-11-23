<template>
  <div class="well">
        <span class="amount">{{ numberOfReviews }}</span>
        {{rating}} Star Review{{ numberOfReviews === 1 ? '' : 's' }}
    </div>
</template>

<script>
export default {
    name: "star-summary",
    props: ["rating"],
    computed: {
        numberOfReviews() {
            return this.$store.state.reviews.reduce((currentCount, review) => {
                return currentCount + (review.rating === Number.parseInt(this.rating));
            }, 0);
        }
    }
}
</script>

<style>

</style>