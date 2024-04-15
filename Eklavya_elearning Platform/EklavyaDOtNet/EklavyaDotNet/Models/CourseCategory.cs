using System;
using System.Collections.Generic;

namespace EklavyaDotNet.Models
{
    public partial class CourseCategory
    {
        public CourseCategory()
        {
            Courses = new HashSet<Course>();
        }

        public int CourseCatId { get; set; }
        public string? CourseCatName { get; set; }

        public virtual ICollection<Course> Courses { get; set; }
    }
}
