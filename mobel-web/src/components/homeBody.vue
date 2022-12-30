<template>
    <div class="homeBody">
        <slot />
    </div>
</template>

<script>

export default {
    name: 'HomeBody',
    setup() {
        return {

        }
    }
}

</script>

<style scoped>
.homeBody {
    width: 100vw;
    height: 91vh;
    overflow: auto;
    background-color: whitesmoke;
}
</style>