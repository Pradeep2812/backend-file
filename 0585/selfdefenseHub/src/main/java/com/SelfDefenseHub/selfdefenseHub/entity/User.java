package com.SelfDefenseHub.selfdefenseHub.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User implements UserDetails {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long userId;
      @Column(name = "user_name")
      private String name;
      @Column(name = "user_email",unique = true)
      private String email;
      @Column(name = "user_password",length = 500)
      private String password;
      private String gender;
      @Column( length = 1000)
      private String about;
      @Column(name = "user_image" )
      private String image;
      @Column( length = 1000)
      private String address;
      @Column(name = "phone")
      private String phone;
      @Column(name = "personal_goal")
      private String personalGoal;
      @Column(name = "level")
      private String level;
      @Column(name = "preference")
      private String preference;

      private List<String> roles = new ArrayList<>();

      // Spring Security Part

      @Override
      public Collection<? extends GrantedAuthority> getAuthorities() {
            return this.roles.stream().map(SimpleGrantedAuthority::new).toList();
      }

      @Override
      public String getUsername() {
            return this.email;
      }
      @Override
      public String getPassword() {
            return this.password;
      }

      @Override
      public boolean isAccountNonExpired() {
            return true;
      }

      @Override
      public boolean isAccountNonLocked() {
            return true;
      }

      @Override
      public boolean isCredentialsNonExpired() {
            return true;
      }

      @Override
      public boolean isEnabled() {
            return true;
      }
}
