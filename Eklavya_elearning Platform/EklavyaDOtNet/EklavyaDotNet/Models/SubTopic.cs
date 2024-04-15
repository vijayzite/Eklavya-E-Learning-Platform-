using System;
using System.Collections.Generic;

namespace EklavyaDotNet.Models
{
    public partial class SubTopic
    {
        public long SubtId { get; set; }
        public string? SubtIndexNo { get; set; }
        public string? SubtTitle { get; set; }
        public string? SubtDesc { get; set; }
        public string? SubtThumbPath { get; set; }
        public string? SubtFilePath { get; set; }
        public string? SubtVideoPath { get; set; }
        public long? ChapterChapterId { get; set; }
        public long? CourseidCourseId { get; set; }

        public virtual Chapter? ChapterChapter { get; set; }
        public virtual Course? CourseidCourse { get; set; }
    }
}
