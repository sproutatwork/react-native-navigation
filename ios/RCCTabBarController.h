#import <UIKit/UIKit.h>
#import <React/RCTBridge.h>

@interface RCCTabBarController : UITabBarController <UITabBarDelegate>

- (instancetype)initWithProps:(NSDictionary *)props children:(NSArray *)children globalProps:(NSDictionary*)globalProps bridge:(RCTBridge *)bridge;
- (void)performAction:(NSString*)performAction actionParams:(NSDictionary*)actionParams bridge:(RCTBridge *)bridge completion:(void (^)(void))completion;
- (void)handleOverlayButton:(BOOL)toggle;

@property(nonatomic,copy)NSMutableArray * isInterceptArr;
@property (nonatomic) BOOL tabBarHidden;

@end
