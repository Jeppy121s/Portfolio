import * as React from 'react';
import { useEffect, useState } from 'react';
import { Text, View, StyleSheet, FlatList, Button} from 'react-native';
const API = 'https://randomuser.me/api/?results=10';

const renderItem = ({item}) => <Product fname={item.name.first} lname={item.name.last} country={item.location.country} />;



const Product = (props) => (
  <View style={styles.item}>
    
    
    <Text style={styles.itemText}>name: {props.fname} {props.lname}</Text>
    <Text style={styles.itemText}>country: {props.country}</Text>

    
  </View>
);

const People=[];
    
export default function App() {

  const [data, setData] = useState([]);
  
  useEffect(() => {
    fetch(API)
    .then((res) => res.json())
    .then((json) => {setData(json);});
}, []);
    
  return (
  <View style={styles.container}>

  
  <FlatList style={styles.productList}
  data={data.results}
   renderItem={renderItem}
   keyExtractor={(item) => item.id.value}/>

   
  
 
    </View>

  );

}




const styles = StyleSheet.create({
  productList:{alignContent:"stretch",width:"100%",},
  container: {flex: 1,justifyContent: 'center',  paddingTop: 40,  backgroundColor: '#ecf0f1',padding: 8,},
  item:{borderWidth:1,padding:10,margin:5,borderRadius:5,backgroundColor:"red"},
  itemText:{color:"white"},
  image:{width:2}
});