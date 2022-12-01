<template>
  <div class="topic-list">
    <div v-for="topic in topics" v-bind:key="topic.id" class="topic">
      {{ topic.title }}
    </div>
  </div>
</template>

<script>
import topicService from "@/services/TopicsService.Js"
export default {
  name: 'topic-list',
  data() {
    return {
      topics: []
    }
  },
  created(){

    topicService.list().then(
      (response)=>{
        this.topics=response.data
      }
    )
  }
}
</script>

<style>
.topic-list {
  padding: 20px 20px;
  margin: 0 auto;
  max-width: 600px;
}
.topic {
  font-size: 24px;
  border-bottom: 1px solid #f2f2f2;
  padding: 10px 20px;
}
.topic:last-child {
  border: 0px;
}
</style>