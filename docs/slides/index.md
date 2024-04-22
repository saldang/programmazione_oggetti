---
layout: page
title: Slides
permalink: /slides/
---

## {{page.title}}

{% for slide in site.static_files %}

{% if slide.path contains slides %}

- [{{folder.name}}]({{site.baseurl}}{{slide.path}})

  {% endif %}
  {% endfor %}
