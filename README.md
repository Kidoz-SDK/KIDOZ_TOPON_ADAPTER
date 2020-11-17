


# KIDOZ_TOPON_ADAPTER
Kidoz TopOn mediation adapter Version 1.0 
Built and tested with TopOn SDK v5.7.1

</br>

**Prerequisits:**
* To use the Kidoz SDK adapter for TopOn you should make sure you have:
1. TopOn SDK integrated in your project as explained [HERE](https://docs.toponad.com/#/en-us/android/android_doc/android_access_doc):
2. A fully functional TopOn ad placement.
3. Kidoz SDK built with your project.

3.1. You can get Kidoz SDK as a Gradle dependency (together with it's needed dependencies) using the following lines:
```
    compile group: 'org.greenrobot', name: 'eventbus', version: '3.0.0'
    compile 'com.kidoz.sdk:KidozSDK:0.8.8.8@aar'
```
3.2. Please make sure you have a set up Kidoz publisher account.

3.3. Add the Kidoz TopOn mediation plugin by coping `` kidoz-topon-release.aar`` to the libs folder in your project.

3.4 Make sure you have added libs folder to your dependencies by:

 ```
  implementation fileTree(include: ['*.jar','*.aar'], dir: 'libs')  
```

3.5  Add Custom Network in TopOn's Network , Fill in the Network Name as explained [HERE](https://docs.toponad.com/#/en-us/android/NetworkAccess/customnetwork/customnetwork):

3.6  Fill in the Adaper's Class Name for each ad type :
 
 ```
 Rewarded Video: com.kidoz.mediation.topon.adapters.KidozTopOnMediationRewardedAdapter
 
 Interstitial: com.kidoz.mediation.topon.adapters.KidozTopOnMediationInterstitialAdapter
 
 Banner: com.kidoz.mediation.topon.adapters.KidozTopOnMediationBannerAdapter 
```
<br/>
**Example for adding Custom Network:
</br>

</br>
<a href="url"><img src="https://cdn.kidoz.net/new/sdk/GITHUB_GRAPHICS/KIDOZ_SDK_Documentaions/TopOn-CustomNetwork.png" align="left" height="659" width="994" ></a>
</br>


3.7 Add the Ad Sources for Custom Network and fill in the Parameters PublisherId ,PublisherToken and UnitID for each ad type in JSON strings type:
 ```
 {"AppID":"publisherId", "Token":"publisherToken","UnitID":"unitId"}
```

<br/>
**Example for adding the Ad Source:
</br>

</br>
<a href="url"><img src="https://cdn.kidoz.net/new/sdk/GITHUB_GRAPHICS/KIDOZ_SDK_Documentaions/TopOn-AdSource.png" align="left" height="659" width="994" ></a>
</br>


## Important note: ##
While mapping the Kidoz Ad unit on TopOn, it is highly recommended to run some Json validator on the parameters passed to the Custom Network Ad Sources (AppID, Token and UnitID). This method may minimize parsing mistakes that may rise on initial connection.


License
--------

    Copyright 2015 KIDOZ, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

