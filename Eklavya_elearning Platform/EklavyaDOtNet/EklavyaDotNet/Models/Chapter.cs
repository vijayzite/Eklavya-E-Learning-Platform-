using System;
using System.Collections.Generic;

namespace EklavyaDotNet.Models
{
    public partial class Chapter
    {
        public Chapter()
        {
            SubTopics = new HashSet<SubTopic>();
        }

        public long ChapterId { get; set; }
        public string? ChapterIndexNo { get; set; }
        public string? ChapterTitle { get; set; }
        public string? ChapterDesc { get; set; }
        public string? ChapterThumbPath { get; set; }
        public string? ChapterFilePath { get; set; }
        public string? ChapterVideoPath { get; set; }
        public long? CourseCourseId { get; set; }

        public virtual Course? CourseCourse { get; set; }
        public virtual ICollection<SubTopic> SubTopics { get; set; }
    }
}
