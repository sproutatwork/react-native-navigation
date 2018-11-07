//
//  UIViewController+RCCBackButtonHandler.h
//  ReactNativeNavigation
//
//  Created by Fabrizio Rizzonelli on 07/11/2018.
//  Copyright © 2018 artal. All rights reserved.
//

#ifndef UIViewController_RCCBackButtonHandler_h
#define UIViewController_RCCBackButtonHandler_h


#endif /* UIViewController_RCCBackButtonHandler_h */

#import <UIKit/UIKit.h>
@protocol RCCBackButtonHandlerProtocol <NSObject>
@optional
// Override this method in UIViewController derived class to handle 'Back' button click
-(BOOL)navigationShouldPopOnBackButton;
@end
@interface UIViewController (RCCBackButtonHandler) <RCCBackButtonHandlerProtocol>
@end
