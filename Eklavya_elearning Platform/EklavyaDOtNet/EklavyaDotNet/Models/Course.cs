using System;
using System.Collections.Generic;

namespace EklavyaDotNet.Models
{
    public partial class Course
    {
        public Course()
        {
            Chapters = new HashSet<Chapter>();
            SubTopics = new HashSet<SubTopic>();
        }

        public long CourseId { get; set; }
        public string? CourseTitle { get; set; }
        public string? CourseDesc { get; set; }
        public string? CourseType { get; set; }
        public float? CoursePrice { get; set; }
        public string? CourseThumbPath { get; set; }
        public string? IntroVideoPath { get; set; }
        public int? CourseCategoryCourseCatId { get; set; }
        public long? UserUserId { get; set; }
        public sbyte? FlagActive { get; set; }

        public virtual CourseCategory? CourseCategoryCourseCat { get; set; }
        public virtual User? UserUser { get; set; }
        public virtual ICollection<Chapter> Chapters { get; set; }
        public virtual ICollection<SubTopic> SubTopics { get; set; }
    }
}
