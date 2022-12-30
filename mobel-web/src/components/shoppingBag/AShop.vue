<template>
    <div v-for="(goods, i) in shop.data" :key="goods.id" class="goods">
        <div style="height: 15vh; display: flex; align-items: center;">
            <SelectButton :is_select="is_select[i]" :selectMes="selectMes[i]" @getSelects="getSelects" />
        </div>

        <img style="height: 15vh; width: 15vh;" :src="'http://localhost:3000' + goods.goodsMes.photoUrl" alt="">
        <div class="goodsMes">
            <div style="line-height: 25px; width: 100%;">
                {{ goods.goodsMes.name }}
            </div>
            <div style="background-color: chocolate; line-height: 16px; font-size: 14px; 
                color: azure;height: 20px; border-radius: 2px; padding: 2px;">
                {{ goods.goodsMes.tags }}
            </div>
            <div class="priceAndNum">
                <div>
                    {{ goods.goodsMes.price }}
                </div>
                <div class="numController">
                    <button>-</button>
                    <div>{{ goods.goodsNum }}</div>
                    <button>+</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { ref } from 'vue';
import { useStore } from 'vuex';
import SelectButton from './selectButton.vue';

export default {
    name: "AShop",
    props: ["shop"],
    emits: ['getSelects'],
    setup(props, context) {
        const store = useStore();
        let is_select = ref([]);
        let selectMes = ref([]);

        const getSelects = () => {
            selectMes.value = []
            for (let i = 0; i < props.shop.data.length; i++) {
                selectMes.value.push({ type: 'goods', data: props.shop.data[i].id });
                for (let j = 0; j < store.state.shoppingbag.selectsId.length; j++) {
                    if (props.shop.data[i].id === store.state.shoppingbag.selectsId[j]) {
                        is_select.value[i] = true;
                        break;
                    }
                }
                if (!is_select.value[i]) is_select.value[i] = false;
            }
            context.emit('getSelects');
        }
        getSelects();

        return {
            is_select,
            selectMes,
            getSelects
        };
    },
    components: { SelectButton }
}

</script>

<style scoped>
.goods {
    display: flex;
}

.goodsMes {
    width: calc(96vw - 10vw - 15vh);
    padding: 1vh 2vw;
    display: flex;
    flex-wrap: wrap;
    flex-shrink: 0;
}

.priceAndNum {
    width: 100%;
    display: flex;
    justify-content: space-between;
}

.numController {
    height: 3vh;
    display: flex;
    align-items: center;
}

.numController>button {
    height: 3vh;
    border: 0;
    background-color: chocolate;
    border: 1px solid chocolate;
    color: antiquewhite;
}

.numController>div {
    width: 7vw;
    height: 3vh;
    display: flex;
    align-items: center;
    justify-content: center;
    border: 1px solid chocolate;
}
</style>