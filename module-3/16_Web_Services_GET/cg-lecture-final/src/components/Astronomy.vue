<template>
  <div >
      <div v-if="isLoading">
          Loading...
          <img src="@/assets/ping_pong_loader.gif" />
      </div>
      <div v-if="!isLoading">
        <h1>{{picOfTheDay.title}}</h1>
        <img v-bind:src="picOfTheDay.hdurl" />
        <h2>{{picOfTheDay.copyright + ', ' + picOfTheDay.date}}</h2>
        <p>{{picOfTheDay.explanation}}</p>
      </div>
  </div>
</template>

<script>
import AstronomyService from '@/services/AstronomyService.js'

export default {
    name: "astronomy",
    data() {
        return {
            picOfTheDay: {},
            isLoading: true
        }
    },
    created() {
        //all the code in here is going to run as soon
        //as the page loads this component
        console.log("Before our service call")
        
        AstronomyService.getPicOfTheDay().then(
            (response) => {
                console.log("We received a response")
               this.picOfTheDay = response.data;
               this.isLoading = false;
            }
        )
        console.log("After our service call")

/*
        AstronomyService.getNearEarthObjects('2022-11-30', '2022-12-31').then(
            (response) => {

            }
        ); */
    }
}
</script>

<style>
img {
    width:400px;
}
</style>