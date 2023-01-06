<template>
    <div class="shopBag" v-if="is_search">
        <div v-for="(shop, i) in shoppingBagMes" :key="shop.id" class="shopBody">
            <div class="shopBody-Title">
                <div style="width: 10vw; height: 5vh; display: flex; justify-content: center; align-items: center;">
                    <div style="width: 2.5vh; height: 2.5vh; border-radius: 50%; border: 1px solid chocolate;
                         display: flex; justify-content: center; align-items: center; color: white;"
                        :style="buttonStyle[i].style" @click="clickButton('shop', i, 0)">
                        <el-icon style=" transform: scale(0.8);">
                            <Check />
                        </el-icon>
                    </div>
                </div>
                <div>
                    {{ shop.shopName }}
                </div>
            </div>
            <!-- <AShop :shop="shop" @getSelects="getSelects" /> -->
            <!-- 每件商品 -->
            <div v-for="(goods, j) in shop.data" :key="goods.id" class="goods">
                <div style="height: 15vh; display: flex; align-items: center;">
                    <div style="width: 10vw; height: 5vh; display: flex; justify-content: center; align-items: center;">
                        <div style="width: 2.5vh; height: 2.5vh; border-radius: 50%; border: 1px solid chocolate;
                         display: flex; justify-content: center; align-items: center; color: white;"
                            :style="buttonStyle[i].data[j].style" @click="clickButton('goods', i, j)">
                            <el-icon style=" transform: scale(0.8);">
                                <Check />
                            </el-icon>
                        </div>
                    </div>
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
                            <button type="button" @click="changeNum(i, j, '-')">-</button>
                            <div>{{ goods.goodsNum }}</div>
                            <button type="button" @click="changeNum(i, j, '+')">+</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="shopBottum">
        <div class="leftSelect">
            <div style="width: 10vw; height: 5vh; display: flex; justify-content: center; align-items: center;">
                <div style="width: 2.5vh; height: 2.5vh; border-radius: 50%; border: 1px solid chocolate;
                         display: flex; justify-content: center; align-items: center; color: white;"
                    :style="AllSelectStyle.style" @click="clickButton('all', 0, 0)">
                    <el-icon style=" transform: scale(0.8);">
                        <Check />
                    </el-icon>
                </div>
            </div>
            <div>全选</div>
        </div>
        <div class="rightMes">
            <div>
                <div class="gongji">共计:</div>
                <div style="color: red;">￥{{ price }}</div>
            </div>
            <button type="button" @click="goOrder">结算</button>
        </div>
    </div>
</template>

<script>
import { useStore } from 'vuex';
import $ from 'jquery';
import { ref } from 'vue';
import { computed } from 'vue';
import router from '@/router';

export default {
    name: "ShopBody",
    setup() {
        const store = useStore();

        let buttonStyle = ref([]);

        let AllSelectStyle = ref({ style: { backgroundColor: 'white' }, is_select: false });

        let is_search = ref(false)

        const price = computed(() => {
            let num = 0;
            for (let i = 0; i < buttonStyle.value.length; i++) {
                for (let j = 0; j < buttonStyle.value[i].data.length; j++) {
                    if (buttonStyle.value[i].data[j].is_select) {
                        num += parseFloat(shoppingBagMes.value[i].data[j].goodsMes.price * shoppingBagMes.value[i].data[j].goodsNum);
                    }
                }
            }
            return num.toFixed(2);
        })

        const cmp = (a, b) => {
            if (a.shopId < b.shopId)
                return 1;
            return -1;
        };
        store.commit('removeSelectsId');
        let shoppingBagMes = ref([]);
        const getShoppingBag = () => {
            $.ajax({
                url: "http://localhost:3000/query/shoppingbag",
                type: "get",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                data: {
                    userId: store.state.user.id,
                },
                success: resp => {
                    let nowshopNum = -1, lastShopId = "";
                    resp.sort(cmp);
                    for (let a of resp) {
                        if (a.shopId != lastShopId) {
                            nowshopNum++;
                            lastShopId = a.shopId;
                            shoppingBagMes.value.push({ id: nowshopNum, shopName: "", shopId: a.shopId, data: [] });
                            buttonStyle.value.push({ style: { backgroundColor: 'white' }, is_select: false, data: [] });
                        }
                        const value = { ...a, goodsMes: [] };
                        shoppingBagMes.value[nowshopNum].data.push(value);
                    }
                    for (let i = shoppingBagMes.value.length - 1; i > -1; i--) {
                        $.ajax({
                            url: "http://localhost:3000/query/shop/byid",
                            type: "Get",
                            headers: {
                                Authorization: "Bearer " + store.state.user.token,
                            },
                            data: {
                                id: shoppingBagMes.value[i].shopId,
                            },
                            success: resp => {
                                shoppingBagMes.value[i].shopName = resp.shopName;
                                for (let j = 0; j < shoppingBagMes.value[i].data.length; j++) {
                                    buttonStyle.value[i].data.push({ style: { backgroundColor: 'white' }, is_select: false });
                                    $.ajax({
                                        url: "http://localhost:3000/query/goods/byId",
                                        type: "Get",
                                        headers: {
                                            Authorization: "Bearer " + store.state.user.token,
                                        },
                                        data: {
                                            goodsId: shoppingBagMes.value[i].data[j].goodsId,
                                        },
                                        success: resp => {
                                            shoppingBagMes.value[i].data[j].goodsMes = resp;
                                            if (j === shoppingBagMes.value[i].data.length - 1 && i === 0) {
                                                is_search.value = true;
                                            }
                                        }
                                    });
                                }
                            }
                        });
                    }
                }
            });
        };
        getShoppingBag();

        const clickButton = (type, i, j) => {
            if (type === 'shop') {
                buttonStyle.value[i].is_select = !buttonStyle.value[i].is_select;
                buttonStyle.value[i].style.backgroundColor = buttonStyle.value[i].is_select ? 'chocolate' : 'white';
                for (; j < buttonStyle.value[i].data.length; j++) {
                    buttonStyle.value[i].data[j].is_select = buttonStyle.value[i].is_select;
                    buttonStyle.value[i].data[j].style.backgroundColor = buttonStyle.value[i].style.backgroundColor;
                }
            } else if (type === 'goods') {
                buttonStyle.value[i].data[j].is_select = !buttonStyle.value[i].data[j].is_select;
                buttonStyle.value[i].data[j].style.backgroundColor = buttonStyle.value[i].data[j].is_select ? 'chocolate' : 'white';
                let isAll = true;
                for (let k = 1; k < buttonStyle.value[i].data.length; k++) {
                    if (buttonStyle.value[i].data[k].is_select !== buttonStyle.value[i].data[k - 1].is_select) isAll = false;
                }
                if (isAll === true)
                    buttonStyle.value[i].is_select = buttonStyle.value[i].data[j].is_select;
                else
                    buttonStyle.value[i].is_select = false;
                buttonStyle.value[i].style.backgroundColor = buttonStyle.value[i].is_select ? 'chocolate' : 'white';
            } else if (type === 'all') {
                AllSelectStyle.value.is_select = !AllSelectStyle.value.is_select;
                AllSelectStyle.value.style.backgroundColor = AllSelectStyle.value.is_select ? 'chocolate' : 'white';
                for (; i < buttonStyle.value.length; i++) {
                    buttonStyle.value[i].is_select = AllSelectStyle.value.is_select;
                    buttonStyle.value[i].style.backgroundColor = AllSelectStyle.value.style.backgroundColor;
                    for (j = 0; j < buttonStyle.value[i].data.length; j++) {
                        buttonStyle.value[i].data[j].is_select = buttonStyle.value[i].is_select;
                        buttonStyle.value[i].data[j].style.backgroundColor = buttonStyle.value[i].style.backgroundColor;
                    }
                }
            }

            if (type !== 'all') {
                let select = buttonStyle.value[0].is_select, is_selectAll = true;
                for (i = 0; i < buttonStyle.value.length; i++) {
                    if (buttonStyle.value[i].is_select !== select) {
                        is_selectAll = false;
                        break;
                    }
                    for (j = 0; j < buttonStyle.value[i].data.length; j++) {
                        if (buttonStyle.value[i].data[j].is_select !== select) {
                            is_selectAll = false;
                            break;
                        }
                    }
                }
                if (is_selectAll === true)
                    AllSelectStyle.value.is_select = select;
                else
                    AllSelectStyle.value.is_select = false;
                AllSelectStyle.value.style.backgroundColor = AllSelectStyle.value.is_select ? 'chocolate' : 'white';
            }
        }

        const changeNum = (i, j, type) => {
            shoppingBagMes.value[i].data[j].goodsNum = shoppingBagMes.value[i].data[j].goodsNum + (type === '+' ? 1 : -1);
            $.ajax({
                url: 'http://localhost:3000/update/shoppingbag',
                type: 'post',
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                data: {
                    id: shoppingBagMes.value[i].data[j].id,
                    type: 'changeNum',
                    goodsNum: shoppingBagMes.value[i].data[j].goodsNum,
                },
                success: resp => {
                    if (resp.error_message !== 'success')
                        shoppingBagMes.value[i].data[j].goodsNum -= type === '+' ? 1 : -1;
                }
            })
        }

        const goOrder = () => {
            for (let i = 0; i < buttonStyle.value.length; i++) {
                for (let j = 0; j < buttonStyle.value[i].data.length; j++) {
                    if (buttonStyle.value[i].data[j].is_select) {
                        store.commit('addSelectsId', shoppingBagMes.value[i].data[j]);
                    }
                }
            }
            store.commit("updateIsHome", false);
            router.push({ name: 'order' });
        }

        return {
            buttonStyle,
            is_search,
            shoppingBagMes,
            AllSelectStyle,
            price,
            clickButton,
            changeNum,
            goOrder,
        };
    },
    components: {}
}

</script>

<style scoped>
.shopBag {
    width: 100%;
    height: 77vh;
    overflow: auto;
}

.shopBody {
    width: 96%;
    margin: 1vh 2%;
    background-color: white;
    border-radius: 5px;
    padding: 1vh 2vw;
}

.shopBody-Title {
    display: flex;
    align-items: center;
}

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

.shopBottum {
    width: 100vw;
    height: 8vh;
    background-color: white;
    padding: 1vh 4vw;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.rightMes,
.leftSelect {
    display: flex;
    height: 100%;
    align-items: center;
}

.rightMes>div {
    display: flex;
    padding: 0 10px;
}

.rightMes>div>.gongji {
    font-size: 14px;
    color: gray;
    font-weight: 700;
}

.rightMes>button {
    width: 20vw;
    height: 80%;
    border: 0;
    border-radius: 5px;
    background-color: chocolate;
    color: antiquewhite;
}
</style>