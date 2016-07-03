/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */
import React, { Component } from 'react';
import IntentLauncher, { IntentConstant } from 'react-native-intent-launcher'
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';

class Example extends Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}
          onPress={this.jumpToSettings}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.android.js
        </Text>
        <Text style={styles.instructions}>
          Shake or press menu button for dev menu
        </Text>
      </View>
    );
  }

  jumpToSettings = () => {
    IntentLauncher.startActivity({action: 'android.settings.APPLICATION_DETAILS_SETTINGS', data: 'package:com.example'})
  };
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('Example', () => Example);
