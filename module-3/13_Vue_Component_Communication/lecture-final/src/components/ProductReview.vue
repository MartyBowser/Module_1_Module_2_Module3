<template>
  <div class="main">
    <h2>Product Reviews for {{ $store.state.name }}</h2>

    <p class="description">{{ $store.state.description }}</p>

    <div class="well-display">
        
        <div v-on:click="displayMessage('hello')" class="well">
          <span class="amount">{{ averageRating }}</span>
          Average Rating
        </div>

        <star-summary rating="1"></star-summary>
        <star-summary rating="2"></star-summary>
        <star-summary rating="3"></star-summary>
        <star-summary rating="4"></star-summary>
        <star-summary rating="5"></star-summary>
      
    </div>

    <add-review></add-review>

    <div
      class="review"
      v-bind:class="{ favorited: review.favorited }"
      v-for="review in $store.state.reviews"
      v-bind:key="review.id"
    >
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          v-bind:title="review.rating + ' Star Review'"
          class="ratingStar"
          v-for="n in review.rating"
          v-bind:key="n"
        />
      </div>
      <h3>{{ review.title }}</h3>

      <p>{{ review.review }}</p>

      <p>
        Favorite?
        <input type="checkbox" v-model="review.favorited" />
      </p>
    </div>
  </div>
</template>

<script>
import StarSummary from "./StarSummary.vue";
import AddReview from "./AddReview.vue";

export default {
  name: "product-review",
  components: {
    StarSummary, AddReview
  },
  data() {
    return {

    };
  },
  methods: {
    displayMessage(message) {
      alert(message);
    },
 
  },
  computed: {
    averageRating() {
      let sum = this.$store.state.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / this.$store.state.reviews.length).toFixed(2);
    },
  
  }
};
</script>

<style scoped>

div.main {
  margin: 1rem 0;
}

div.main div.well-display {
  display: flex;
  justify-content: space-around;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review.favorited {
  background-color: lightyellow;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main div.review h3 {
  display: inline-block;
}

div.main div.review h4 {
  font-size: 1rem;
}

div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input, div.form-element > select {
  height: 30px;
  width: 300px;
}
div.form-element > textarea {
  height: 60px;
  width: 300px;
}
form > input[type=button] {
  width: 100px;
}
form > input[type=submit] {
  width: 100px;
  margin-right: 10px;
}
</style>

