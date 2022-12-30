<template>
    <div class="home">
        <div class="leftHome">
            <div class="optItem1" @click="openItem1">表单</div>
            <div class="Item1" :style="Item1Style">
                <div @click="(nowCom = 1)">用户</div>
                <div @click="(nowCom = 2)">货物</div>
                <div @click="(nowCom = 3)">商店</div>
            </div>
        </div>
        <div class="rightHome">
            <User v-if="nowCom === 1" />
            <Goods v-if="(nowCom === 2)" />
            <Shop v-if="nowCom === 3" />
        </div>
    </div>
</template>

<script>
import Goods from '@/components/goods/Goods.vue';
import Shop from '@/components/shop/shop.vue';
import User from '@/components/user/User.vue';
import { ref } from 'vue';

export default {
    name: "HomeView",
    setup() {
        let nowCom = ref(0);

        let Item1Style = ref({
            height: '0px'
        })

        const openItem1 = () => {
            if (Item1Style.value.height === '0px')
                Item1Style.value.height = '150px';
            else
                Item1Style.value.height = '0px';
        }

        return {
            nowCom,
            Item1Style,
            openItem1
        };
    },
    components: { User, Goods, Shop }
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
    overflow: auto;
}

.optItem1 {
    height: 55px;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: orange;
}

.Item1 {
    width: 100%;
    transition: 300ms;
    overflow: hidden;
    box-sizing: border-box;
    background-color: wheat;
}

.Item1>div {
    height: 50px;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>