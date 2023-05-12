[33mcommit 85ad0c30feab6791a82171c0aaf03615d488dc97[m[33m ([m[1;36mHEAD -> [m[1;32mmain[m[33m, [m[1;31morigin/HUYNH[m[33m)[m
Author: PHAN VAN HUYNH <june.utf@gmail.com>
Date:   Thu Apr 20 14:42:15 2023 +0900

    削除の権限を分けます

[1mdiff --git a/src/main/java/com/example/VisaAPI/controller/UserDeleteController.java b/src/main/java/com/example/VisaAPI/controller/UserDeleteController.java[m
[1mindex 82095a5..3f0313a 100644[m
[1m--- a/src/main/java/com/example/VisaAPI/controller/UserDeleteController.java[m
[1m+++ b/src/main/java/com/example/VisaAPI/controller/UserDeleteController.java[m
[36m@@ -34,31 +34,38 @@[m [mpublic class UserDeleteController {[m
 			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");[m
 			String formattedDateTime = currentDateTime.format(formatter);[m
 			List<UserDeleteModel>  user = userDeleteService.CheckDeleteByUsername(userDeleteModel);[m
[31m-			if(user.size()!=0) {[m
[31m-				userDeleteModel.setNote(formattedDateTime +"に"+ userDeleteModel.getLoginUsername()+"が削除しました");[m
[31m-				int userRole = userDeleteService.DeleteByUsernameRole(userDeleteModel);[m
[31m-				if(userRole == 1) {[m
[31m-						userDeleteModel.setStatusRole("DELETED");[m
[31m-							userDeleteModel.setStatus("SUCCESS");[m
[31m-							int information = userDeleteService.DeleteByUsernameUser(userDeleteModel);[m
[31m-								if(information == 1) {[m
[31m-									userDeleteModel.setStatusInformation("DELETED");[m
[31m-								}else {[m
[31m-									userDeleteModel.setStatusInformation("在留カード情報がありません");[m
[31m-								}[m
[32m+[m			[32mList<UserDeleteModel>  role = userDeleteService.CheckRoleLoginUser(userDeleteModel);[m
[32m+[m			[32muserDeleteModel.setRole(role.get(0).getRole());[m
[32m+[m			[32mif(role.get(0).getRole().equals("ADMIN") || userDeleteModel.getUsername().equals(userDeleteModel.getLoginUsername())) {[m
[32m+[m				[32mif(user.size()!=0) {[m
[32m+[m					[32muserDeleteModel.setNote(formattedDateTime +"に"+ userDeleteModel.getLoginUsername()+"が削除しました");[m
[32m+[m					[32mint userRole = userDeleteService.DeleteByUsernameRole(userDeleteModel);[m
[32m+[m					[32mif(userRole == 1) {[m
[32m+[m							[32muserDeleteModel.setStatusRole("DELETED");[m
[32m+[m								[32muserDeleteModel.setStatus("SUCCESS");[m
[32m+[m								[32mint information = userDeleteService.DeleteByUsernameUser(userDeleteModel);[m
[32m+[m									[32mif(information == 1) {[m
[32m+[m										[32muserDeleteModel.setStatusInformation("DELETED");[m
[32m+[m									[32m}else {[m
[32m+[m										[32muserDeleteModel.setStatusInformation("在留カード情報がありません");[m
[32m+[m									[32m}[m
[32m+[m						[32m}else {[m
[32m+[m							[32muserDeleteModel.setNote(formattedDateTime +"に"+ userDeleteModel.getLoginUsername()+"が削除されませんでした");[m
[32m+[m							[32muserDeleteModel.setStatusRole("ERROR");[m
[32m+[m							[32muserDeleteModel.setStatusInformation("ERROR");[m
[32m+[m							[32muserDeleteModel.setStatus("DEFEATED");[m
[32m+[m						[32m}[m
 					}else {[m
[31m-						userDeleteModel.setNote(formattedDateTime +"に"+ userDeleteModel.getLoginUsername()+"が削除されませんでした");[m
 						userDeleteModel.setStatusRole("ERROR");[m
 						userDeleteModel.setStatusInformation("ERROR");[m
 						userDeleteModel.setStatus("DEFEATED");[m
[32m+[m						[32muserDeleteModel.setNote(formattedDateTime +"に"+ userDeleteModel.getUsername()+"が削除されたまたは存じません");[m
[32m+[m						[32mreturn ResponseEntity.ok(userDeleteModel);[m
 					}[m
[31m-				}else {[m
[31m-					userDeleteModel.setStatusRole("ERROR");[m
[31m-					userDeleteModel.setStatusInformation("ERROR");[m
[31m-					userDeleteModel.setStatus("DEFEATED");[m
[31m-					userDeleteModel.setNote(formattedDateTime +"に"+ userDeleteModel.getUsername()+"が削除されたまたは存じません");[m
[31m-					return ResponseEntity.ok(userDeleteModel);[m
[31m-				}[m
[32m+[m			[32m}else {[m
[32m+[m				[32muserDeleteModel.setStatus("DEFEATED");[m
[32m+[m				[32muserDeleteModel.setNote(formattedDateTime +"に"+ "権限がないので、削除できませんでした");[m
[32m+[m			[32m}[m
 			return ResponseEntity.ok(userDeleteModel);[m
 		}[m
 }[m
[1mdiff --git a/src/main/java/com/example/VisaAPI/impl/UserDeleteImpl.java b/src/main/java/com/example/VisaAPI/impl/UserDeleteImpl.java[m
[1mindex 651feb7..d7321d7 100644[m
[1m--- a/src/main/java/com/example/VisaAPI/impl/UserDeleteImpl.java[m
[1m+++ b/src/main/java/com/example/VisaAPI/impl/UserDeleteImpl.java[m
[36m@@ -22,6 +22,9 @@[m [mpublic class UserDeleteImpl implements UserDeleteService{[m
 		public int  DeleteByUsernameUser(UserDeleteModel userDeleteModel){[m
 			return mapper.DeleteByUsernameUser(userDeleteModel);[m
 		}[m
[32m+[m		[32mpublic List<UserDeleteModel> CheckRoleLoginUser(UserDeleteModel userDeleteModel){[m
[32m+[m			[32mreturn mapper.CheckRoleLoginUser(userDeleteModel);[m
[32m+[m		[32m}[m
 		public List<UserDeleteModel> CheckDeleteByUsername(UserDeleteModel userDeleteModel){[m
 			return mapper.CheckDeleteByUsername(userDeleteModel);[m
 		}[m
[1mdiff --git a/src/main/java/com/example/VisaAPI/mapper/UserDeleteMapper.java b/src/main/java/com/example/VisaAPI/mapper/UserDeleteMapper.java[m
[1mindex 60e87ac..d0201a5 100644[m
[1m--- a/src/main/java/com/example/VisaAPI/mapper/UserDeleteMapper.java[m
[1m+++ b/src/main/java/com/example/VisaAPI/mapper/UserDeleteMapper.java[m
[36m@@ -10,6 +10,7 @@[m [mimport com.example.VisaAPI.model.UserModel;[m
 public interface UserDeleteMapper {[m
 	int DeleteByUsernameRole(UserDeleteModel userDeleteModel);[m
 	int DeleteByUsernameUser(UserDeleteModel userDeleteModel);[m
[32m+[m	[32mList<UserDeleteModel> CheckRoleLoginUser(UserDeleteModel userDeleteModel);[m
 	List<UserDeleteModel> CheckDeleteByUsername(UserDeleteModel userDeleteModel);[m
 	List<UserModel> SelectDeleteByUsername(UserModel userModel);[m
 }[m
[1mdiff --git a/src/main/java/com/example/VisaAPI/model/UserDeleteModel.java b/src/main/java/com/example/VisaAPI/model/UserDeleteModel.java[m
[1mindex dbab029..573f904 100644[m
[1m--- a/src/main/java/com/example/VisaAPI/model/UserDeleteModel.java[m
[1m+++ b/src/main/java/com/example/VisaAPI/model/UserDeleteModel.java[m
[36m@@ -6,8 +6,9 @@[m [mimport lombok.Data;[m
 public class UserDeleteModel {[m
 	private String loginUsername;[m
 	private String username;[m
[32m+[m	[32mprivate String role;[m
 	private String statusRole;[m
 	private String statusInformation;[m
[31m-	private String status;[m
 	private String note;[m
[32m+[m	[32mprivate String status;[m
 }[m
[1mdiff --git a/src/main/java/com/example/VisaAPI/service/UserDeleteService.java b/src/main/java/com/example/VisaAPI/service/UserDeleteService.java[m
[1mindex 882b1f0..9f708d8 100644[m
[1m--- a/src/main/java/com/example/VisaAPI/service/UserDeleteService.java[m
[1m+++ b/src/main/java/com/example/VisaAPI/service/UserDeleteService.java[m
[36m@@ -8,6 +8,7 @@[m [mimport com.example.VisaAPI.model.UserModel;[m
 public interface UserDeleteService {[m
 	int DeleteByUsernameRole(UserDeleteModel userDeleteModel);[m
 	int DeleteByUsernameUser(UserDeleteModel userDeleteModel);[m
[32m+[m	[32mList<UserDeleteModel> CheckRoleLoginUser(UserDeleteModel userDeleteModel);[m
 	List<UserDeleteModel> CheckDeleteByUsername(UserDeleteModel userDeleteModel);[m
 	List<UserModel> SelectDeleteByUsername(UserModel userModel);[m
 [m
[1mdiff --git a/src/main/resources/mapper/UserDeleteMapper.xml b/src/main/resources/mapper/UserDeleteMapper.xml[m
[1mindex 5610de9..24149da 100644[m
[1m--- a/src/main/resources/mapper/UserDeleteMapper.xml[m
[1m+++ b/src/main/resources/mapper/UserDeleteMapper.xml[m
[36m@@ -11,12 +11,13 @@[m
     	UPDATE visa_user_api SET status = 'DELETE',note=#{note} WHERE username = #{username}[m
     </update>[m
     <select id="CheckDeleteByUsername" resultType="com.example.VisaAPI.model.UserDeleteModel">[m
[31m-    	select note,username from visa_user_api_role where status = 'DELETE' and username = #{username}[m
[32m+[m[41m    [m	[32mselect note,username,role from visa_user_api_role where status = 'ACTIVE' and username = #{username}[m
 	</select>[m
 	<select id="SelectDeleteByUsername" resultType="com.example.VisaAPI.model.UserModel">[m
 		SELECT    id,username,visa_id,name,birthday,sex,country,address,visa_date,visa_type[m
 		FROM visa_user_api WHERE username = #{username} AND status = 'ACTIVE'[m
[31m-[m
 	</select>[m
[31m-[m
[32m+[m	[32m<select id="CheckRoleLoginUser" resultType="com.example.VisaAPI.model.UserDeleteModel">[m
[32m+[m		[32mselect role from visa_user_api_role where username=#{loginUsername}[m
[32m+[m	[32m</select>[m
 </mapper>[m
\ No newline at end of file[m
