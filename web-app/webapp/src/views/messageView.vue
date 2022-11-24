<template>
    <div class="MessageView">
        <div class="MesTop">
            消息列表
            <div class="el-icon-circle-plus-outline MesTopBut"></div>
        </div>
        <div class="MesBody">
            <div class="APeople" v-for="Peo in MesList" :key="Peo.id">
                <div class="PeoBody">
                    <div class="PeoImg"><img :src="Peo.url" alt=""></div>
                    <div class="PeoMes">
                        <div class="PeoName">
                            {{ Peo.name }}
                            <div class="Mestime">{{ Peo.time }}</div>
                        </div>
                        <div class="LastMes">{{ Peo.dasc }}</div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</template>

<script>

export default {
    name: 'MessageView',
    data() {
        return {
            MesList: [{
                url: 'https://ss.lanqb.com/fb9d7d15-230a-437f-bbd3-5fef0e821eea.jpg',
                id: 12,
                name: '张三',
                time: '2022/11/15 19:32:34',
                dasc: '给我钱',
                messageList: [
                    { id: 0, time: '2022/11/16 15:30:00', dasc: '在干啥', },
                    { id: 1, time: '2022/11/15 19:37:23', dasc: 'Okk', }
                ],
                myAnswerList: [
                    { id: 0, time: '2022/11/16 15:36:02', dasc: '在搞钱', },
                    { id: 1, time: '2022/11/15 19:32:34', dasc: '给我钱', }
                ]
            }, {
                url: 'https://ss.lanqb.com/fb9d7d15-230a-437f-bbd3-5fef0e821eea.jpg',
                id: 13,
                name: '张三',
                time: '2022/11/15 19:32:34',
                dasc: '给我钱',
                messageList: [
                    { id: 0, time: '2022/11/16 15:30:00', dasc: '在干啥', },
                    { id: 1, time: '2022/11/15 19:37:23', dasc: 'Okk', }
                ],
                myAnswerList: [
                    { id: 0, time: '2022/11/16 15:36:02', dasc: '在搞钱', },
                    { id: 1, time: '2022/11/15 19:32:34', dasc: '给我钱', }
                ]
            }, {
                url: 'https://ss.lanqb.com/fb9d7d15-230a-437f-bbd3-5fef0e821eea.jpg',
                id: 14,
                name: '张三',
                time: '2022/11/15 19:32:34',
                dasc: '给我钱',
                messageList: [
                    { id: 0, time: '2022/11/16 15:30:00', dasc: '在干啥', },
                    { id: 1, time: '2022/11/15 19:37:23', dasc: 'Okk', }
                ],
                myAnswerList: [
                    { id: 0, time: '2022/11/16 15:36:02', dasc: '在搞钱', },
                    { id: 1, time: '2022/11/15 19:32:34', dasc: '给我钱', }
                ]
            }]
        }
    },
    mounted() {
    }
}

</script>

<style scoped>
* {
    box-sizing: border-box;
}

.MessageView {
    background-color: whitesmoke;
}

.MesTop {
    width: 100vw;
    height: 6vh;
    line-height: 6vh;
    text-align: center;
    color: chocolate;
    font-size: 2.5vh;
    font-weight: 800;
    /* box-shadow: 0px 0px 3px gray; */
}

.MesTopBut {
    position: absolute;
    right: 5vw;
    line-height: 6vh;
    font-size: 2.5vh;
    font-weight: 800;
}

.MesBody {
    width: 100vw;
    height: 85vh;
    overflow: auto;
}

.APeople {
    width: 100vw;
    padding: 1vh 3vw 1vh 3vw;
}

.PeoBody {
    width: 100%;
    height: 10vh;
    display: flex;
    padding: 1vh;
    border-radius: 5px;
    background-color: white;
}

.PeoImg {
    height: 8vh;
    width: 8vh;
}

.PeoImg>img {
    width: 100%;
    height: 100%;
    border-radius: 50%;
}

.PeoMes {
    width: calc(100vw - 6vw - 10vh);
    padding: 1vh;
}

.Mestime {
    position: absolute;
    right: calc(3vw + 1vh);
    font-weight: 300;
    font-size: 12px;
    color: rgb(94, 94, 94);
}

.PeoName {
    display: flex;
    align-items: center;
    font-weight: 800;
}

.LastMes {
    font-size: 12px;
    font-weight: 300;
    color: rgb(44, 44, 44);
    margin-top: 1vh;
}
</style>