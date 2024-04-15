using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace EklavyaDotNet.Models
{
    public partial class eklavyaContext : DbContext
    {
        public eklavyaContext()
        {
        }

        public eklavyaContext(DbContextOptions<eklavyaContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Approve> Approves { get; set; } = null!;
        public virtual DbSet<Chapter> Chapters { get; set; } = null!;
        public virtual DbSet<Course> Courses { get; set; } = null!;
        public virtual DbSet<CourseCategory> CourseCategories { get; set; } = null!;
        public virtual DbSet<EnrollDetail> EnrollDetails { get; set; } = null!;
        public virtual DbSet<EnrolledCourse> EnrolledCourses { get; set; } = null!;
        public virtual DbSet<HibernateSequence> HibernateSequences { get; set; } = null!;
        public virtual DbSet<Order> Orders { get; set; } = null!;
        public virtual DbSet<Role> Roles { get; set; } = null!;
        public virtual DbSet<SubTopic> SubTopics { get; set; } = null!;
        public virtual DbSet<User> Users { get; set; } = null!;

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
                optionsBuilder.UseMySql("server=localhost;port=3306;user=root;password=root;database=eklavya", Microsoft.EntityFrameworkCore.ServerVersion.Parse("8.0.31-mysql"));
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.UseCollation("utf8mb4_0900_ai_ci")
                .HasCharSet("utf8mb4");

            modelBuilder.Entity<Approve>(entity =>
            {
                entity.HasKey(e => e.ApvId)
                    .HasName("PRIMARY");

                entity.ToTable("approve");

                entity.Property(e => e.ApvId)
                    .ValueGeneratedNever()
                    .HasColumnName("apv_id");

                entity.Property(e => e.Certifications)
                    .HasMaxLength(255)
                    .HasColumnName("certifications");

                entity.Property(e => e.Description)
                    .HasMaxLength(255)
                    .HasColumnName("description");

                entity.Property(e => e.Experience)
                    .HasMaxLength(255)
                    .HasColumnName("experience");

                entity.Property(e => e.Qualification)
                    .HasMaxLength(255)
                    .HasColumnName("qualification");

                entity.Property(e => e.UStatus)
                    .HasMaxLength(255)
                    .HasColumnName("u_status");

                entity.Property(e => e.UserId).HasColumnName("user_id");
            });

            modelBuilder.Entity<Chapter>(entity =>
            {
                entity.ToTable("chapter");

                entity.HasIndex(e => e.CourseCourseId, "FKlrspswalo0vcy1h4fqqiyxt0i");

                entity.Property(e => e.ChapterId)
                    .ValueGeneratedNever()
                    .HasColumnName("chapter_id");

                entity.Property(e => e.ChapterDesc)
                    .HasMaxLength(255)
                    .HasColumnName("chapter_desc");

                entity.Property(e => e.ChapterFilePath)
                    .HasMaxLength(255)
                    .HasColumnName("chapter_file_path");

                entity.Property(e => e.ChapterIndexNo)
                    .HasMaxLength(255)
                    .HasColumnName("chapter_index_no");

                entity.Property(e => e.ChapterThumbPath)
                    .HasMaxLength(255)
                    .HasColumnName("chapter_thumb_path");

                entity.Property(e => e.ChapterTitle)
                    .HasMaxLength(255)
                    .HasColumnName("chapter_title");

                entity.Property(e => e.ChapterVideoPath)
                    .HasMaxLength(255)
                    .HasColumnName("chapter_video_path");

                entity.Property(e => e.CourseCourseId).HasColumnName("course_course_id");

                entity.HasOne(d => d.CourseCourse)
                    .WithMany(p => p.Chapters)
                    .HasForeignKey(d => d.CourseCourseId)
                    .HasConstraintName("FKlrspswalo0vcy1h4fqqiyxt0i");
            });

            modelBuilder.Entity<Course>(entity =>
            {
                entity.ToTable("course");

                entity.HasIndex(e => e.UserUserId, "FKq41d267juo4gigglkch82iyyc");

                entity.HasIndex(e => e.CourseCategoryCourseCatId, "FKq7jjyiy7lxt4b95lmcqcpk5mr");

                entity.Property(e => e.CourseId)
                    .ValueGeneratedNever()
                    .HasColumnName("course_id");

                entity.Property(e => e.CourseCategoryCourseCatId).HasColumnName("course_category_course_cat_id");

                entity.Property(e => e.CourseDesc)
                    .HasMaxLength(255)
                    .HasColumnName("course_desc");

                entity.Property(e => e.CoursePrice).HasColumnName("course_price");

                entity.Property(e => e.CourseThumbPath)
                    .HasMaxLength(255)
                    .HasColumnName("course_thumb_path");

                entity.Property(e => e.CourseTitle)
                    .HasMaxLength(255)
                    .HasColumnName("course_title");

                entity.Property(e => e.CourseType)
                    .HasMaxLength(255)
                    .HasColumnName("course_type");

                entity.Property(e => e.FlagActive)
                    .HasColumnName("flagActive")
                    .HasDefaultValueSql("'0'");

                entity.Property(e => e.IntroVideoPath)
                    .HasMaxLength(255)
                    .HasColumnName("intro_video_path");

                entity.Property(e => e.UserUserId).HasColumnName("user_user_id");

                entity.HasOne(d => d.CourseCategoryCourseCat)
                    .WithMany(p => p.Courses)
                    .HasForeignKey(d => d.CourseCategoryCourseCatId)
                    .HasConstraintName("FKq7jjyiy7lxt4b95lmcqcpk5mr");

                entity.HasOne(d => d.UserUser)
                    .WithMany(p => p.Courses)
                    .HasForeignKey(d => d.UserUserId)
                    .HasConstraintName("FKq41d267juo4gigglkch82iyyc");
            });

            modelBuilder.Entity<CourseCategory>(entity =>
            {
                entity.HasKey(e => e.CourseCatId)
                    .HasName("PRIMARY");

                entity.ToTable("course_category");

                entity.Property(e => e.CourseCatId)
                    .ValueGeneratedNever()
                    .HasColumnName("course_cat_id");

                entity.Property(e => e.CourseCatName)
                    .HasMaxLength(255)
                    .HasColumnName("course_cat_name");
            });

            modelBuilder.Entity<EnrollDetail>(entity =>
            {
                entity.ToTable("enroll_details");

                entity.Property(e => e.EnrollDetailId)
                    .ValueGeneratedNever()
                    .HasColumnName("enroll_detail_id");

                entity.Property(e => e.CourseId).HasColumnName("course_id");

                entity.Property(e => e.InstId).HasColumnName("inst_id");

                entity.Property(e => e.Price).HasColumnName("price");
            });

            modelBuilder.Entity<EnrolledCourse>(entity =>
            {
                entity.HasKey(e => e.EnrollId)
                    .HasName("PRIMARY");

                entity.ToTable("enrolled_courses");

                entity.Property(e => e.EnrollId)
                    .ValueGeneratedNever()
                    .HasColumnName("enroll_id");

                entity.Property(e => e.CId).HasColumnName("c_id");

                entity.Property(e => e.CType)
                    .HasMaxLength(255)
                    .HasColumnName("c_type");

                entity.Property(e => e.Title)
                    .HasMaxLength(255)
                    .HasColumnName("title");

                entity.Property(e => e.UId).HasColumnName("u_id");
            });

            modelBuilder.Entity<HibernateSequence>(entity =>
            {
                entity.HasNoKey();

                entity.ToTable("hibernate_sequence");

                entity.Property(e => e.NextVal).HasColumnName("next_val");
            });

            modelBuilder.Entity<Order>(entity =>
            {
                entity.HasKey(e => e.OrdId)
                    .HasName("PRIMARY");

                entity.ToTable("orders");

                entity.HasIndex(e => e.UserUserId, "FK38709695otpk064vi3y92u08s");

                entity.Property(e => e.OrdId).HasColumnName("ord_id");

                entity.Property(e => e.OrdDate)
                    .HasMaxLength(255)
                    .HasColumnName("ord_date");

                entity.Property(e => e.TotalAmt).HasColumnName("total_amt");

                entity.Property(e => e.UserUserId).HasColumnName("user_user_id");

                entity.Property(e => e.Username)
                    .HasMaxLength(255)
                    .HasColumnName("username");

                entity.HasOne(d => d.UserUser)
                    .WithMany(p => p.Orders)
                    .HasForeignKey(d => d.UserUserId)
                    .HasConstraintName("FK38709695otpk064vi3y92u08s");
            });

            modelBuilder.Entity<Role>(entity =>
            {
                entity.ToTable("role");

                entity.Property(e => e.RoleId)
                    .ValueGeneratedNever()
                    .HasColumnName("role_id");

                entity.Property(e => e.Name)
                    .HasMaxLength(255)
                    .HasColumnName("name");
            });

            modelBuilder.Entity<SubTopic>(entity =>
            {
                entity.HasKey(e => e.SubtId)
                    .HasName("PRIMARY");

                entity.ToTable("sub_topic");

                entity.HasIndex(e => e.ChapterChapterId, "FK7ury91wapy3swl7f3cvjq8y6m");

                entity.HasIndex(e => e.CourseidCourseId, "FKn326ubxvhrdpo6uhaneg317go");

                entity.Property(e => e.SubtId)
                    .ValueGeneratedNever()
                    .HasColumnName("subt_id");

                entity.Property(e => e.ChapterChapterId).HasColumnName("chapter_chapter_id");

                entity.Property(e => e.CourseidCourseId).HasColumnName("courseid_course_id");

                entity.Property(e => e.SubtDesc)
                    .HasMaxLength(255)
                    .HasColumnName("subt_desc");

                entity.Property(e => e.SubtFilePath)
                    .HasMaxLength(255)
                    .HasColumnName("subt_file_path");

                entity.Property(e => e.SubtIndexNo)
                    .HasMaxLength(255)
                    .HasColumnName("subt_index_no");

                entity.Property(e => e.SubtThumbPath)
                    .HasMaxLength(255)
                    .HasColumnName("subt_thumb_path");

                entity.Property(e => e.SubtTitle)
                    .HasMaxLength(255)
                    .HasColumnName("subt_title");

                entity.Property(e => e.SubtVideoPath)
                    .HasMaxLength(255)
                    .HasColumnName("subt_video_path");

                entity.HasOne(d => d.ChapterChapter)
                    .WithMany(p => p.SubTopics)
                    .HasForeignKey(d => d.ChapterChapterId)
                    .HasConstraintName("FK7ury91wapy3swl7f3cvjq8y6m");

                entity.HasOne(d => d.CourseidCourse)
                    .WithMany(p => p.SubTopics)
                    .HasForeignKey(d => d.CourseidCourseId)
                    .HasConstraintName("FKn326ubxvhrdpo6uhaneg317go");
            });

            modelBuilder.Entity<User>(entity =>
            {
                entity.ToTable("users");

                entity.HasIndex(e => e.RoleRoleId, "FKgx0oqf703aa8cmro1cimhh13v");

                entity.Property(e => e.UserId)
                    .ValueGeneratedNever()
                    .HasColumnName("user_id");

                entity.Property(e => e.Address)
                    .HasMaxLength(255)
                    .HasColumnName("address");

                entity.Property(e => e.Email)
                    .HasMaxLength(255)
                    .HasColumnName("email");

                entity.Property(e => e.FirstName)
                    .HasMaxLength(255)
                    .HasColumnName("first_name");

                entity.Property(e => e.LastName)
                    .HasMaxLength(255)
                    .HasColumnName("last_name");

                entity.Property(e => e.Pass)
                    .HasMaxLength(255)
                    .HasColumnName("pass");

                entity.Property(e => e.PhoneNo)
                    .HasMaxLength(255)
                    .HasColumnName("phone_no");

                entity.Property(e => e.RoleRoleId).HasColumnName("role_role_id");

                entity.Property(e => e.Username)
                    .HasMaxLength(255)
                    .HasColumnName("username");

                entity.HasOne(d => d.RoleRole)
                    .WithMany(p => p.Users)
                    .HasForeignKey(d => d.RoleRoleId)
                    .HasConstraintName("FKgx0oqf703aa8cmro1cimhh13v");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
