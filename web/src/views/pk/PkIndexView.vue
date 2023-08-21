<template>
<PlayGround v-if="$store.state.pk.status === 'playing'">对战</PlayGround>
<MatchGround v-if="$store.state.pk.status === 'matching'"/>
</template>

<script>
import PlayGround from "../../components/PlayGround"
import { onUnmounted,onMounted } from "vue";
import { useStore } from "vuex";
import MatchGround from "../../components/MatchGround"
export default{
    components:{
        PlayGround,
        MatchGround
    },
    setup(){
        const store = useStore();
        const socketurl = `ws://localhost:3000/websocket/${store.state.user.token}/`;
        let socket = null;
        onMounted(()=>{
            socket = new WebSocket(socketurl);

            store.commit("updateOpponent",{
                opponent_photo:"https://cdn.acwing.com/media/article/image/2022/08/09/1_1db2488f17-anonymous.png",
                opponent_username:"我的对手"
            })

            socket.onopen = ()=>{
                console.log("connected");
                store.commit("updateSocket",socket);
            }
            socket.onmessage = msg =>{
                const data = JSON.parse(msg.data);
                if(data.event === "start-matching"){
                    store.commit("updateOpponent",{
                        opponent_username:data.opponent_username,
                        opponent_photo:data.opponent_photo
                    })
                }
                setTimeout(()=>{
                    store.commit("updateStatus","playing");
                    
                },2000);
                store.commit("updateGamemap",data.gamemap);
            }

            socket.onclose = ()=>{
                console.log("disconnected");
            }

        })
        onUnmounted(()=>{
            socket.close();
            store.commit("updateStatus","matching");
        })
    }

}
</script>

<style scoped>
</style>