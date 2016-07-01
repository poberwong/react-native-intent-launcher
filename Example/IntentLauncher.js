import { NativeModules } from 'react-native'
import React from 'react'
let nativeCaller = NativeModules.IntentLauncher
/*payload: {action: {}}*/
export default {
	startActivity (payload) {
		nativeCaller.startActivity(payload.action, payload.extra || { pober: 'wong' })
	}
}
