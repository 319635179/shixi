<template>
    <div class="home">
        <div class="leftHome"></div>
        <div class="rightHome">
            <User v-if="nowCom === 0" />
        </div>
    </div>
</template>

<script>
import User from '@/components/user/User.vue';


export default {
    name: "HomeView",
    setup() {
        let nowCom = 0;
        return {
            nowCom
        };
    },
    components: { User }
}

</script>

<style scoped>
.home {
    width: 100%;
    height: calc(100vh - 64px);
    display: flex;
}

.leftHome {
    width: 10%;
    height: 100%;
    background-color: burlywood;
}

.rightHome {
    width: 90%;
    height: 100%;
    padding: 20px;
    background-color: steelblue;
}
</style>