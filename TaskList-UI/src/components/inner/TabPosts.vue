<template>
  <table class="lineage" border="1">

   <div>Posts component</div>

  </table>
</template>

<script>



export default {
  name: 'TabPosts',

  components: {
      
  },


  data () {
    return {
      products: ['Boots', 'Socks', 'Tie'],
      messages: ['hello', 'vue', 'js'],
      shoppingItems: [
        {name: 'apple', price: '10'},
      {name: 'orange', price: '12'}]
    };
  },

  computed: {
    totalProducts () {
      return this.products.reduce((sum, product) => {
        return sum + product.quantity;
      }, 0);
    }
  },

  created () {
 
  }
  
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

</style>
