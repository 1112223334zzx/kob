<template>
    <ContentView>我的Bots</ContentView>
</template>
    
<script>
import ContentView from "../../../components/ContentView"
import $ from "jquery"

export default {
    components: {
        ContentView,
    },
    setup(){
        $.ajax({
            url:"http://127.0.0.1:3000/user/bot/add/",
            type:"POST",
            data:{
                title:"Bot的标题",
                description:"bot的描述",
                content:"bot的代码",
            },
            headers:{
                Authorization:"Bearer " + localStorage.getItem("jwt_token"),
            },
            success(resp){
                console.log(resp);
            },
            error(resp){
                console.log(resp);
            }
        })
    }
}
</script>
    
<style scoped></style>