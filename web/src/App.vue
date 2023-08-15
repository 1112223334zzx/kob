<template>
  <div>名称：{{ bot_name }}</div>
  <div>战力值：{{ bot_ratings }}</div>
  <router-view></router-view>
</template>

<script>
import { ref } from 'vue';
import $ from 'jquery';
export default {
  name: 'App',

  setup:()=>{
    console.log("111")
    let bot_name = ref("");
    let bot_ratings = ref("");
    $.ajax({
      url:"http://localhost:3000/pk/bot/",
      type:"get",
      success:resp => {
        console.log(resp)
        bot_name.value = resp.name
        bot_ratings.value = resp.ratings
      }
    })
    return{
      bot_name,
      bot_ratings
    }
  }
  

}
</script>

<style>

</style>
