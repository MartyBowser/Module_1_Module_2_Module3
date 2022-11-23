<template>
  <div>
<a href="#" v-on:click.prevent="showForm = !showForm">{{showForm ? 'Hide Form' : 'Show Form' }}</a>

    <form v-if="showForm === true" v-on:submit.prevent="addNewReview()">
      <div class="form-element">
          <label for="reviewer">Reviewer:</label>
          <input id="reviewer" type="text" v-model="newReview.reviewer" />
      </div>
      <div class="form-element">
          <label for="title">Title:</label>
          <input id="title" type="text" v-model="newReview.title" />
      </div>
      <div class="form-element">
          <label for="rating">Rating:</label>
          <img src="../assets/star.png" class="unSelectedStar" v-bind:class="{selectedStar: newReview.rating >= 1 }" v-on:click="setRating(1)" />
          <img src="../assets/star.png" class="unSelectedStar" v-bind:class="{ selectedStar: newReview.rating >= 2 }" v-on:click="setRating(2)" />
          <img src="../assets/star.png" class="unSelectedStar" v-bind:class="{ selectedStar: newReview.rating >= 3 }" v-on:click="setRating(3)"/>
          <img src="../assets/star.png" class="unSelectedStar" v-bind:class="{ selectedStar: newReview.rating >= 4 }" v-on:click="setRating(4)"/>
          <img src="../assets/star.png" class="unSelectedStar" v-bind:class="{ selectedStar: newReview.rating >= 5 }" v-on:click="setRating(5)" />
      </div>
      <div class="form-element">
          <label for="review">Review:</label>
          <textarea id="review" v-model="newReview.review"></textarea>
      </div>

      <input type="submit" value="Save" />
      <input v-on:click="resetForm()" type="button" value="Cancel" />
    </form>
   </div>
</template>

<script>
export default {
    name: "add-review",
    data() {
        return {
             showForm: false,
            newReview: {rating:0},
        }
    },
    methods: {
    addNewReview(){
      this.newReview.rating = Number.parseInt(this.newReview.rating);

      this.$store.commit('ADD_REVIEW', this.newReview)

      this.resetForm();
    },
    resetForm() {
      this.newReview = {};
      this.showForm = false;
    },
    setRating(value){
      console.log(value);
      this.newReview.rating = Number.parseInt(value);
      console.log(this.newReview.rating);
    }
    }
}
</script>

<style>
.unSelectedStar {
  width: 25px;
  height: 25px;
}
.unSelectedStar:hover {
  width: 50px;
  height: 50px;
}
.selectedStar{
  width:50px;
  height:50px;
}
</style>