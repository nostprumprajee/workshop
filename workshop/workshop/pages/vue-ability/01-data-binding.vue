<template>
  <div class="con-center">
    <h1>Hello {{ name }}</h1>
    <input type="text" :value="name"/>
  </div>
</template>

<script>
export default {
  data() {
      setInterval(() => {
          this.name += "*";
      }, 3000);
    return {
      name: "Nost"
    };
  }
};
</script>

<style>
.con-center {
  text-align: center;
  margin-top: 1rem;
}
</style>